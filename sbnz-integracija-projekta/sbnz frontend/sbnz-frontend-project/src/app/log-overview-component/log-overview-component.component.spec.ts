import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogOverviewComponentComponent } from './log-overview-component.component';

describe('LogOverviewComponentComponent', () => {
  let component: LogOverviewComponentComponent;
  let fixture: ComponentFixture<LogOverviewComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogOverviewComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LogOverviewComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
