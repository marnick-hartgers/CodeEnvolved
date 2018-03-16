const int FIXED_EVENT_ENTER = 1024;
const int FIXED_EVENT_LOOP = 1025;
const int FIXED_EVENT_EXIT = 1026;
const int FIXED_EVENT_NONE = -1;

struct StateDefinition {
  int *(onEvent)(int eventId);
};

struct StateMachineObject {
  int current_state = -1;
  StateDefinition states[];

  void setStateDefinition(int state, StateDefinition def) {
    states[state] = def;
  }

  void changeState(int state) {
    int res = -1;
    if (current_state >= 0) {
      res = states[current_state].onEvent(FIXED_EVENT_ENTER);
      if (res != FIXED_EVENT_NONE) {
        changeState(res);
        return;
      }
    }

    current_state = state;
    res = states[current_state].onEvent(FIXED_EVENT_EXIT);
    if (res != FIXED_EVENT_NONE) {
      changeState(res);
      return;
    }
  }

  int loop() {
    int res = states[current_state].onEvent(FIXED_EVENT_LOOP);
    if (res != FIXED_EVENT_NONE) {
      changeState(res);
    }
  }

  int procesEvent(int event) {
    int res = states[current_state].onEvent(event);
    if (res != FIXED_EVENT_NONE) {
      changeState(res);
    }
  }
};

StateMachineObject createStateMachine(int numStates) {
  StateMachineObject a;
  a.states[numStates];
  return a;
}

