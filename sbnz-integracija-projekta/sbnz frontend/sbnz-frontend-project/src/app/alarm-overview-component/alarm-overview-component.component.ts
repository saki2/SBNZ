import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { Alarm, AlarmService } from '../service/AlarmService';
@Component({
  selector: 'app-alarm-overview-component',
  templateUrl: './alarm-overview-component.component.html',
  styleUrls: ['./alarm-overview-component.component.css']
})
export class AlarmOverviewComponentComponent implements OnInit{
  displayedColumns: string[] = ['id', 'timestamp', 'content', 'mitigation'];
  dataSource = new MatTableDataSource<Alarm>([]);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private alarmService: AlarmService) { }

  ngOnInit(): void {
    this.dataSource.paginator = this.paginator;
    this.alarmService.getAlarms().subscribe(
      (alarm: Alarm) => {
        this.dataSource.data = [...this.dataSource.data, alarm];
      },
      (error) => console.error(error)
    );
  }
}
