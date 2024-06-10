import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponentComponent } from './login-component/login-component.component';
import { RegisterComponentComponent } from './register-component/register-component.component';
import { AlarmOverviewComponentComponent } from './alarm-overview-component/alarm-overview-component.component';
import { LogOverviewComponentComponent } from './log-overview-component/log-overview-component.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },  // Default route
  { path: 'login', component: LoginComponentComponent },
  { path: 'register', component: RegisterComponentComponent },
  { path: 'alarm-overview', component: AlarmOverviewComponentComponent },
  { path: 'log-overview', component: LogOverviewComponentComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }