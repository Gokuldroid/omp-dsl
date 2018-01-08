$Parms = @{};
if(%groupacceptmailfromui%){
    $Parms.RequireSenderAuthenticationEnabled =%groupacceptmailfrom% -ne 'Internal';
}
if(%restrictusersui%){
    $GroupsAndUsers = %groupsandusers%.split(',');
    if(%overwriteexistingrestrictions%){
        $Parms.RejectMessagesFrom = $GroupsAndUsers;
    }else {
        $Parms.RejectMessagesFrom = @{Add = $GroupsAndUsers};
    }
}
Set-DistributionGroup -Identity %identity% @Parms; 
