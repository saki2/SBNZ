import { Injectable } from '@angular/core';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';
import { Observable } from 'rxjs';

export interface LogEntry {
  id: number;
  timestamp: Date;
  source: string;
  ipAddress: string;
  logType: string; // Adjust according to LogType enum if needed
  content: string;
}

@Injectable({
  providedIn: 'root',
})
export class LogService {
  private socket$: WebSocketSubject<LogEntry>;

  constructor() {
    this.socket$ = webSocket('ws://localhost:8765');
  }

  getLogs(): Observable<LogEntry> {
    return this.socket$.asObservable();
  }
}