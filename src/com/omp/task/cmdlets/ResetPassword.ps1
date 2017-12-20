if(%resetpasswordui%){
    $passwordParms = @{};
    $PasswordChangeType = %passwordchangetype%;
    if($PasswordChangeType -eq 'CustomPassword'){
        $passwordParms.NewPassword = %newpassword%;
    }
    $ChangePasswordOnNextLogon = %changepasswordonnextlogon%;
    if($ChangePasswordOnNextLogon -ne 'n_a'){
        $passwordParms.ForceChangePassword = %changepasswordonnextlogon%;
    }
    $NewPassword = Set-msoluserpassword -UserPrincipalname  %userprincipalname%  @passwordParms;
    $out = New-Object PSObject;
    $out | Add-Member NewPassword $NewPassword;
    $out | %selectcolumns%    
}
if(%passwordneverexpires% -ne 'n_a'){
    Set-msoluser -PasswordNeverExpires %passwordneverexpires%;
}