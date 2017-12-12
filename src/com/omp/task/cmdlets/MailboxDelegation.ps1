if(%sendasui%){
    $SendAsMembers = %sendasmembers%.split(',');
    if(%addremovesendaspermissions% -eq 'AddPermissions'){
        foreach($trustee in $SendAsMembers){
            Add-RecipientPermission -identity %identity% -Trustee $trustee -AccessRights SendAs -Confirm:$false;
        }
    }else{
        foreach($trustee in $SendAsMembers){
            Remove-RecipientPermission -identity %identity% -Trustee $trustee -AccessRights SendAs -Confirm:$false;
        }
    }
}

if(%sendonbehalfui%){
    $trustee = %sendonbehalfmembers%.split(',');
    if(%addremovesendonbehalfpermissions% -eq 'AddPermissions'){
        Set-mailbox -identity %identity%  -Grantsendonbehalfto @{Add=$trustee};
    }else{
        Set-mailbox -identity %identity%  -Grantsendonbehalfto @{Remove=$trustee};
    }
}

if(%fullaccessui%){
    if(%addremovefullaccesspermissions%){
        $users = %fullaccessmembers%.split(',');
        foreach($user in $users){
            Add-MailboxPermission -identity %identity% -user $user -accessrights 'FullAccess';
        }
    }else {
        $users = %fullaccessmembers%.split(',');
        foreach($user in $users){
            Remove-MailboxPermission -identity %identity% -user $user -accessrights 'FullAccess' -Confirm:$false
        }
    }
}