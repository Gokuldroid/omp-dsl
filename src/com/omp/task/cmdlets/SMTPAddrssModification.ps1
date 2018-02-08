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
        if($appendcsvvalues){
            $othersmtpaddressold += $email;
        }
    }
}

$othersmtpaddressold;
if($proxyaddresses -ne $null){
    $proxyaddresses = $proxyaddresses -split ','|Where-Object {$_.trim() -ne ''}|%{'smtp:'+$_.Trim()};
    $othersmtpaddressold += $proxyaddresses;
}
if($primarysmtpaddress -eq $null){
    $primarysmtpaddress = $primarysmtpaddressold; 
} 
$cmd = 'Set-Mailbox -Identity '+$identity+' -EmailAddresses SMTP:'+$primarysmtpaddress;
if($proxyaddresses -ne $null){ 
    $proxyaddresses = $othersmtpaddressold |Select -Unique;
    foreach($proxyaddress in $othersmtpaddressold){
        if($proxyaddress -ne ('smtp:'+$primarysmtpaddress)){
            $cmd = $cmd + ','+$proxyaddress;
        } 
    } 
}
Invoke-Expression -Command $cmd;