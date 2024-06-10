import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlarmOverviewComponentComponent } from './alarm-overview-component.component';

describe('AlarmOverviewComponentComponent', () => {
  let component: AlarmOverviewComponentComponent;
  let fixture: ComponentFixture<AlarmOverviewComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlarmOverviewComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlarmOverviewComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
