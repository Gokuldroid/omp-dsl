$identity = %identity%;
$primarysmtpaddress = %primarysmtpaddress%; 
$proxyaddresses = %proxyaddresses%; 
$emails = Get-Mailbox -Identity $identity -ErrorAction stop|select EmailAddresses|%{$_.EmailAddresses}; 
$primarysmtpaddressold; 
$othersmtpaddressold=@(); 
foreach ($email in $emails){
    if($email -clike 'SMTP*'){
        $primarysmtpaddressold = $email -replace 'SMTP:',''; 
    }else{
        $othersmtpaddressold += $email -replace 'SMTP:',''; 
    } 
} 
if($proxyaddresses -ne $null){
    $proxyaddresses = $proxyaddresses -split ','|Where-Object {$_.trim() -ne ''}|%{$_.Trim()}; 
} 
if($appendcsvvalues){
    $proxyaddresses += $othersmtpaddressold; 
} 
if($primarysmtpaddress -eq $null){
    $primarysmtpaddress = $primarysmtpaddressold; 
} 
$cmd = 'Set-Mailbox -Identity '+$identity+' -EmailAddresses ''SMTP:'+$primarysmtpaddress+''''; 
if($proxyaddresses -ne $null){ 
    $proxyaddresses = $proxyaddresses |Select -Unique;
    foreach($proxyaddress in $proxyaddresses){
        if($proxyaddress -ne $primarysmtpaddress){
            $cmd = $cmd + ',''smtp:'+$proxyaddress+''''; 
        } 
    } 
} 
Invoke-Expression -Command $cmd;