$LitigationHoldSettingsUI = %litigationholdsettingsui%;
$Parms = @{};
$Parms.Identity = %identity%;
if($LitigationHoldSettingsUI){
    if(%litigationholdenabled%){
        $Parms.LitigationHoldEnabled = $true;
        $LitigationHoldDuration = %litigationholdduration%;
        if($LitigationHoldEnabled -eq $null){
            $Parms.LitigationHoldDuration = 'Unlimited';
        }else {
            $Parms.LitigationHoldDuration = $LitigationHoldDuration;
        }
        if(%litigationholdowner% -ne $null){
            $Parms.LitigationHoldOwner = %litigationholdowner%;
        }
    }else{
        $Parms.LitigationHoldEnabled = $false;
    }   
}
if(%retentionurl% -ne $null){
    $Parms.RetentionUrl = %retentionurl%;
}
if(%retentioncomment% -ne $null){
    $Parms.RetentionComment = %retentioncomment%;
}
Set-Mailbox @Parms -force;