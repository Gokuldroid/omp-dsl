$Parms = @{};
$Parms.Identity = %identity%;
if(%retentionholdenabled%){
    $Parms.RetentionHoldEnabled = $true;
    $Parms.retentioncomment = %retentioncomment%;
}
$Parms.RetentionPolicy = %retentionpolicy%;
$Parms.retentionurl = %retentionurl%;
$Parms.retaindeleteditemsfor = %retaindeleteditemsfor%;
Set-Mailbox @Parms %retentionholdduration:#startdateforretentionhold,enddateforretentionhold#%   -force;