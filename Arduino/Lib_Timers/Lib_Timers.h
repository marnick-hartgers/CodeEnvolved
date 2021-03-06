/*
 * Made by Marnick Hartgers
 * https://github.com/marnick-hartgers/CodeEnvolved/blob/master/Arduino/Lib_Timers/Lib_Timers.ino
 */

#define NUM_COUNTERS 10


struct TimerObject{
  long interval = -1;
  unsigned long startTime = 0;
  void (*callback)(void);
};

TimerObject timers [NUM_COUNTERS];

void setTimer(int timerIndex, long interval, void (*timerCallback)(void)){
  timers[timerIndex].interval = interval;
  timers[timerIndex].callback = timerCallback;
  timers[timerIndex].startTime = millis();
}

void clearTimer(int timerIndex){
  timers[timerIndex].interval = -1;
}

void resetTimer(int timerIndex){
  timers[timerIndex].startTime = millis();
}

void intervalTimer(int timerIndex, long interval){
  if(timers[timerIndex].callback){
    timers[timerIndex].interval = interval;
  }  
}


void maintainTimers(){
  for(int t = 0; t < NUM_COUNTERS;t++){
    unsigned long timeExpire = timers[t].startTime + (unsigned long)timers[t].interval;
    if(timers[t].interval != -1 && timeExpire < millis()){
      timers[t].callback();
      timers[t].startTime = millis();
    }
  }
}

long getTimerInterval(int timerIndex){
  return timers[timerIndex].interval;
}
