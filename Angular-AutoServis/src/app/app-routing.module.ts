import { KvarCreateComponent } from './kvar/kvarovi-create/kvar-create.component';
import { KvaroviComponent } from './kvar/kvarovi.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { KvarDetailComponent } from './kvar/kvarovi-detail/kvar-detail.component';


const routes: Routes = [
  {
    path: 'kvarovi',
    component: KvaroviComponent,
    //canActivate: [AuthGuardService]
  },
  {
    path: 'kvarovi/create',
    component: KvarCreateComponent,
    //canActivate: [AdminAuthGuardService]
  },
  {
    path: 'students/detail/:id',
    component: KvarDetailComponent,
    //canActivate: [AdminAuthGuardService]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
