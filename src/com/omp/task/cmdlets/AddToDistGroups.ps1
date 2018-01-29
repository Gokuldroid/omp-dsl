$AddToGroups = %addtogroups%;
$RemoveFromGroups = %removefromgroups%;
$userprincipalname = %userprincipalname%;
if($AddToGroups -ne $null){
    $AddToGroups = $AddToGroups.split(',');
    foreach($group in $AddToGroups){
        Add-DistributionGroupMember -Identity $group -Member $userprincipalname;
    }
}

if($RemoveFromGroups -ne $null){
    $RemoveFromGroups = $RemoveFromGroups.split(',');
    foreach($group in $RemoveFromGroups){
        Add-DistributionGroupMember -Identity $group -Member $userprincipalname;
    }
}
