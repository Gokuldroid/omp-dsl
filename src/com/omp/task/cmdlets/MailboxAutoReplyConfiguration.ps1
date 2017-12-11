$autoreplystate = %autoreplystate%;
if($autoreplystate){
    if(%scheduleautoreply%){
        $autoreplystate = 'Scheduled';
    }else{
        $autoreplystate = 'Enabled';
    }
}else{
    $autoreplystate = 'Disabled';
}

$externalAudience = 'None';
if(%enableautoreplyoutsideorg%){
    if(%excludesendersnotincontact%){
       $externalAudience = 'Known';
    }else{
        $externalAudience = 'All';
    }
}
set-mailboxautoreplyconfiguration -identity %identity% -autoreplystate $autoreplystate %autoreplyduration:#starttime,endtime#%  -externalaudience $externalAudience -externalmessage %externalmessage% -internalmessage %internalmessage%