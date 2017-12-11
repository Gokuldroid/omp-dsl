$ModifySendMessageSizeUI = %modifysendmessagesizeui%;
$UseDefaultSendSize = %modifysendmessagesize% -eq 'UseDefaultLimit'; 

$ModifyReceiveMessageSizeUI = %modifyreceivemessagesizeui%;
$UseDefaultReceiveSize = %modifyreceivemessagesize% -eq 'UseDefaultLimit';

$ModifyMessageRestrictions = %modifymessagerestrictions%;
$AcceptFromAllSenders = %acceptmessagesfrom% -eq 'All';
$RejectFromNoSenders = %rejectmessagesfrom% -eq 'NoSenders';

$Parms = @{};
$Parms.Identity = %identity%;
if($ModifySendMessageSizeUI){
    $Parms.MaxSendSize = %maxsendsize%;
}
if($ModifyReceiveMessageSizeUI){
    $Parms.MaxReceiveSize = %maxreceivesize%;
}
if($UseDefaultReceiveSize -or $UseDefaultSendSize){
    $mailboxplan = Get-MailboxPlan -Identity (Get-Mailbox -Identity %identity%).Mailboxplan;
    if($UseDefaultSendSize){
        $Parms.MaxSendSize = $mailboxplan.MaxSendSize
    }
    if($UseDefaultReceiveSize){
        $Parms.MaxReceiveSize = $mailboxplan.MaxReceiveSize;
    }
}
if($ModifyMessageRestrictions){
    if($AcceptFromAllSenders){
        $Parms.AcceptMessagesOnlyFromSendersOrMembers = $null;
    }else {
        $Parms.AcceptMessagesOnlyFromSendersOrMembers = %acceptmessagesfromusers%.split(',');
    }

    if($RejectFromNoSenders){
        $Parms.RejectMessagesFromSendersOrMembers = $null;
    }else {
        $Parms.RejectMessagesFromSendersOrMembers = %rejectmessagesfromusers%.split(',');
    }    
}
Set-Mailbox @Parms;