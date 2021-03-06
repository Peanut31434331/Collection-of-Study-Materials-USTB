#include "epoll.h"
#include "../lib/socket.h"

int lx_set_epoll(int ep_fd, int fd, void * data, int events,bool is_nblk,bool is_add)
{
    int op,ret = 0;
    struct epoll_event ev;
    
    if( is_nblk && lx_set_nonblocking(fd)){
        return -1;
    }
    
    op = is_add? EPOLL_CTL_ADD:EPOLL_CTL_MOD;
    
    ev.data.ptr = data;
    ev.events = events;

    if( epoll_ctl(ep_fd,op,fd,&ev) )
    {
        return -1;
    }
    return 0;
}

char * lx_get_events(unsigned int events,char * buff, size_t len )
{
    int ret = 0,curlen = 0,i = 0;
    static char sbuff[1024];
    unsigned int flags[]= {EPOLLIN,EPOLLPRI,EPOLLOUT,EPOLLRDNORM,EPOLLRDBAND,EPOLLWRNORM,EPOLLWRBAND
                    ,EPOLLMSG,EPOLLERR,EPOLLHUP,EPOLLONESHOT,EPOLLET};
    char * names[] = {"EPOLLIN","EPOLLPRI","EPOLLOUT","EPOLLRDNORM","EPOLLRDBAND","EPOLLWRNORM","EPOLLWRBAND","EPOLLMSG"
                ,"EPOLLERR","EPOLLHUP","EPOLLONESHOT","EPOLLET"};

    if(len < 1){
        buff[0] =0;
        return buff;
    }

    if(buff == NULL)
        buff = sbuff,len = 1024;
    
    for(; i < (int)(sizeof(flags)/sizeof(flags[0])); ++i ){
        if( events & flags[i]){
            ret = snprintf(buff+curlen,len - curlen," %s",names[i]);
            if(ret < 0){
                buff[0]=0;
                return buff;
            }
            curlen += ret;
        }
    }

    return buff;
}
