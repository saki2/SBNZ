import { Injectable } from '@angular/core';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';
import { Observable } from 'rxjs';

export interface Alarm {
  id: number;
  timestamp: Date;
  content: string;
  mitigation: string; // Assuming Mitigation is a string, adjust as necessary
}

@Injectable({
  providedIn: 'root',
})
export class AlarmService {
  private socket$: WebSocketSubject<Alarm>;

  constructor() {
    this.socket$ = webSocket('ws://localhost:8765');
  }


  getAlarms(): Observable<Alarm> {
    return this.socket$.asObservable();
  }
}