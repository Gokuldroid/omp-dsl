if(%ismfaenabled% -ne 'Disabled'){
    $hasDefault=$false;
    $st= New-Object Microsoft.Online.Administration.StrongAuthenticationRequirement;
    $st.RelyingParty= '*';
    $st.State = %ismfaenabled%;
    $methods = %allowedmfamethods%;
    $methodsArray = @();
    if($methods -ne $null){
        $methods = $methods.split(',');
        $defaultmethod = %defaultmfamethod%;
        foreach($method in $methods){
            $methodsArrayObj = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationMethod;
            if($method -eq $defaultmethod){
                $methodsArrayObj.IsDefault= $true;
                $hasDefault=$true;
            };
            $methodsArrayObj.MethodType = $method;
            $methodsArray += $methodsArrayObj;
        } 
    };
    if(-not($hasDefault)){
        $methodsArrayObj = New-Object -TypeName Microsoft.Online.Administration.StrongAuthenticationMethod;
        $methodsArrayObj.IsDefault= $true;
        $methodsArrayObj.MethodType = $defaultmethod;
        $methodsArray += $methodsArrayObj;
    };
    Set-MsolUser -UserPrincipalName %userprincipalname% -StrongAuthenticationRequirements @($st) -StrongAuthenticationMethods $methodsArray;
}else {
    Set-MsolUser -UserPrincipalName %userprincipalname% -StrongAuthenticationRequirements @() -StrongAuthenticationMethods @();
}



Set-MsolUser -UserPrincipalName o365userdummythree@zohocorpadmgrplus.onmicrosoft.com -StrongAuthenticationRequirements @();

Get-MsolUser -UserPrincipalName o365userdummythree@zohocorpadmgrplus.onmicrosoft.com|select *STS*
o365userdummythree@zohocorpadmgrplus.onmicrosoft.com
StsRefreshTokensValidFrom