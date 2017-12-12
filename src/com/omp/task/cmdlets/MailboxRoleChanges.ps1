$addorremoveroles = %addorremoveroles%;
$roles = %roleidentity%.split(',');
foreach($role in $roles){
    if($addorremoveroles -eq 'AddRoles'){
        Add-RoleGroupMember -Identity $role -Member %identity% 
    }elseif($addorremoveroles -eq 'RemoveRoles'){
        Remove-RoleGroupMember -Identity $role -Member %identity% -Confirm:$false 
    }
}