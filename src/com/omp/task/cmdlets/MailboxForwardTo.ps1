$ForwardToOption = %forwardtooption%;
$ForwardingAddress = %forwardingaddress%;
$ForwardingSmtpAddress = %forwardingsmtpaddress%;
$DeliverToMailboxAndForward = %delivertomailboxandforward%;
if($ForwardToOption -eq 'ForwardDisabled'){
    Set-Mailbox -identity %identity%  -ForwardingSmtpaddress $null -ForwardingAddress $null;
}elseif($ForwardToOption -eq 'ToInternal'){
    Set-Mailbox -identity %identity% -ForwardingAddress $ForwardingAddress;
}elseif($ForwardToOption -eq 'ToExternal'){
    Set-Mailbox -identity %identity% -ForwardingSmtpaddress $ForwardingSmtpaddress;
}