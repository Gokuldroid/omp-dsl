$Parms = @{};
$Parms.Identity = %identity%;

if(%modifyauditenabled%){
    $Parms.AuditEnabled = %auditenabled%;
}

if(%modifyauditlogagelimit%){
    $Parms.AuditLogAgeLimit = %auditlogagelimit%;
}

if(%modifyauditowner%){
    $Parms.AuditOwner = %auditowner%;
}

if(%modifyauditdelegate%){
    $Parms.auditdelegate = %auditdelegate%;
}
if(%modifyauditadmin%){
    $Parms.auditadmin = %auditadmin%;
}

Set-Mailbox @Parms -force;