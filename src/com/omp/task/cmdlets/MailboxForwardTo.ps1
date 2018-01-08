$ForwardToOption = %forwardtooption%;
$ForwardingAddress = %forwardingaddress%;
$ForwardingSmtpAddress = %forwardingsmtpaddress%;
$DeliverToMailboxAndForward = %delivertomailboxandforward% -eq '$true';
if($ForwardToOption -eq 'ForwardDisabled'){
    Set-Mailbox -identity %identity%  -ForwardingSmtpaddress $null -ForwardingAddress $null;
}elseif($ForwardToOption -eq 'ToInternal'){
    Set-Mailbox -identity %identity% -ForwardingAddress $ForwardingAddress -DeliverToMailboxAndForward  $DeliverToMailboxAndForward;
}elseif($ForwardToOption -eq 'ToExternal'){
    Set-Mailbox -identity %identity% -ForwardingSmtpaddress $ForwardingSmtpaddress -DeliverToMailboxAndForward $DeliverToMailboxAndForward;
}