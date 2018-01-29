$Identity = %identity%;
 $PermissionSelection = %permissionselection%;
 if($PermissionSelection){
     $PermissionSelection = ConvertFrom-Json($PermissionSelection);
 }
 foreach($Permission in $PermissionSelection){
     if($Permission.ALLOW_OR_DISALLOW -eq 'Allow'){
         $users = $Permission.USERS.Split(',');
         foreach($user in $users){
             Add-MailboxPermission -Identity $Identity -AccessRights $Permission.PERMISSIONS -User $user;
         }
     }else{
         $users = $Permission.USERS.Split(',');
         foreach($user in $users){
             Remove-MailboxPermission -Identity $Identity -AccessRights $Permission.PERMISSIONS -User $user -Confirm:$false;
         }
     }
 }
