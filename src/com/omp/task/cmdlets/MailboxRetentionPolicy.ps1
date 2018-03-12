$Parms = @{};
$Parms.Identity = %identity%;
if(%retentionholdenabled%){
    $Parms.RetentionHoldEnabled = $true;
    $Parms.retentioncomment = %retentioncomment%;
}
$RetentionPolicy =  %retentionpolicy%;
$Retentionurl =  %retentionurl%;
$Retaindeleteditemsfor = %retaindeleteditemsfor%;
if($RetentionPolicy -ne $null){
    $Parms.RetentionPolicy = %retentionpolicy%;
}
if($Retentionurl -ne $null){
    $Parms.Retentionurl = %retentionurl%;
}
if($Retaindeleteditemsfor -ne $null){
    $Parms.Retaindeleteditemsfor = %retaindeleteditemsfor%;
}
Set-Mailbox @Parms %retentionholdduration:#startdateforretentionhold,enddateforretentionhold#%  -force;