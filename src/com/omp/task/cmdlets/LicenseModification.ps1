$user =%userprincipalname%;

$licenses =%licenses%;

$licenseDetails=%services%;

$usagelocation =%usagelocation%;
$operation = %operation%;
if($usagelocation -ne $null){set-msoluser -UserPrincipalName $user -UsageLocation $usagelocation;}

if($operation -eq 'assign'){
    $userObject = Get-Msoluser -userprincipalname $user;
    $alreadyAssignedLicenses = @();
    if($userObject.Licenses){
        foreach($temp in $userObject.Licenses.AccountSkuId){
            $alreadyAssignedLicenses += $temp.ToLower();
        }
    }
    foreach($license in $licenses){
        $ops = New-MsolLicenseOptions -AccountSkuId $license -DisabledPlans $($licenseDetails[$license]);
        if($alreadyAssignedLicenses.contains($license)){
            Set-MsolUserLicense -UserPrincipalName $user  -LicenseOptions $ops;
        }else{
            Set-MsolUserLicense -AddLicenses $license -UserPrincipalName $user  -LicenseOptions $ops;
        }
     }
}elseif($operation -eq 'modify'){
    foreach($license in $licenses){
        $ops = New-MsolLicenseOptions -AccountSkuId $license -DisabledPlans $($licenseDetails[$license]);
        Set-MsolUserLicense -UserPrincipalName $user  -LicenseOptions $ops;
     }
}elseif($operation -eq 'remove-all'){
    $licensesLoc  = get-msoluser -UserPrincipalName $user|select Licenses;
    $licensesLoc = $licensesLoc.Licenses;
    Set-MsolUserLicense -RemoveLicenses $licensesLoc.AccountSkuId -UserPrincipalName $user;
}elseif($operation -eq 'remove-selected'){
    $userObject = Get-Msoluser -userprincipalname $user;
    $alreadyAssignedLicenses = @();
    if($userObject.Licenses){
        foreach($temp in $userObject.Licenses.AccountSkuId){
            $alreadyAssignedLicenses += $temp.ToLower();
        }
    }
    foreach($license in $licenses){
        if($alreadyAssignedLicenses.contains($license)){
            Set-MsolUserLicense -RemoveLicenses $license -UserPrincipalName $user;
        }
    }
}