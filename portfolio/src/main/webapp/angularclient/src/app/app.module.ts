import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { PersonListComponent } from './person-list/person-list.component';
import { PersonFormComponent } from './person-form/person-form.component';
import { PersonService } from './service/person.service';
import { ProjectListComponent } from './project-list/project-list.component';
import { ProjectFormComponent } from './project-form/project-form.component';
import { ProjectService } from './service/project.service';

@NgModule({
  declarations: [
    AppComponent,
    PersonListComponent,
    PersonFormComponent,
    ProjectListComponent,
    ProjectFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [PersonService, ProjectService],
  bootstrap: [AppComponent]
})
export class AppModule { }
