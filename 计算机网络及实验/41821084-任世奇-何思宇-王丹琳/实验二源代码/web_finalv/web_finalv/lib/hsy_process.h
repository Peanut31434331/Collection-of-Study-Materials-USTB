#ifndef LX_PROCESS_H
#define LX_PROCESS_H
#include <sys/types.h>
#include <sys/wait.h>
#include <signal.h>
#include <errno.h>
#include <unistd.h>
#include <pthread.h>

#define LX_PROCESS_NAME_LEN 64

enum lxprocstat
{
    LX_UNFORK = 0,
    LX_UNWAIT,
    LX_KILLED,
    LX_WAITED
};
typedef enum lxprocstat lxprocstat;

struct lxprocinfo
{
    pid_t pid;
    char name[LX_PROCESS_NAME_LEN];
    lxprocstat stat;
};
typedef struct lxprocinfo lxprocinfo;

static void lxkillprocs(lxprocinfo * procs,int size )
{
    int i = 0;
    for(;i < size; i++)
    {
        if( procs[i].stat == LX_UNWAIT )
        {
            kill(procs[i].pid,SIGKILL);
            procs[i].stat = LX_KILLED;
        }
    }
}

static long lxgettid(pthread_t * ptr)
{
    if(ptr != NULL)
        return (long) *ptr;
    return (long) pthread_self();
}

static int lxwaitpid(pid_t pid)
{
    pid_t ret;
    int status;
    do{
        ret = waitpid(pid,&status,0);
        if(ret == -1){
            if( errno == EINTR){
				std::cout << "waitpid return for intr,continue,pid:" << (long)pid <<" .("<< errno << ","<< strerror(errno) << ")\n";
                continue;
            }
			std::cout << "waitpid error. param pid:" << (long)pid << " .(" << errno << "," << strerror(errno) << ")\n";
      
            return -1;
        }else if(WIFEXITED(status) ){
			//printf("process %ld exited,status:%d \n",(long)pid,WEXITSTATUS(status));
			std::cout << "process " << (long)pid << "exited,status:" << WEXITSTATUS(status) << " \n";
        }else if(WIFSIGNALED(status )){
            //printf("%ld,signal %d\n",(long)pid,WTERMSIG(status));
			std::cout << (long)pid << ",signal" << WTERMSIG(status) << " \n";
        }else if(WIFSTOPPED(status) ){
            //printf("%ld,stop %d\n", (long)pid, WSTOPSIG(status));
			std::cout << (long)pid << ",stop" << WSTOPSIG(status) << " \n";
        }else if( WIFCONTINUED(status))
            //printf("%ld, continue\n",(long)pid);
			std::cout << (long)pid << ", continue\n";

    }while( !WIFEXITED(status) && !WIFSIGNALED(status) );
    return 0;
}

#endif
