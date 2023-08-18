import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PersonListComponent } from './person-list/person-list.component';
import { PersonFormComponent } from './person-form/person-form.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { ProjectFormComponent } from './project-form/project-form.component';

const routes: Routes = [
  { path: 'persons', component: PersonListComponent },
  { path: 'projects', component: ProjectListComponent },
  { path: 'addpersontoproject', component: PersonFormComponent },
  { path: 'addproject', component: ProjectFormComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
