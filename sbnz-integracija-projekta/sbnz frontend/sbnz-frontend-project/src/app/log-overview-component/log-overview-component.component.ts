
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { LogEntry, LogService } from '../service/LogService';

@Component({
  selector: 'app-log-overview-component',
  templateUrl: './log-overview-component.component.html',
  styleUrls: ['./log-overview-component.component.css']
})
export class LogOverviewComponentComponent {
  displayedColumns: string[] = ['id', 'timestamp', 'source', 'ipAddress', 'logType', 'content'];
  dataSource = new MatTableDataSource<LogEntry>([]);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private logService: LogService) { }

  ngOnInit(): void {
    this.logService.getLogs().subscribe(
      (log: LogEntry) => {
        this.dataSource.data = [...this.dataSource.data, log];
        this.dataSource.paginator = this.paginator;
      },
      (error) => console.error(error)
    );
  }
}
