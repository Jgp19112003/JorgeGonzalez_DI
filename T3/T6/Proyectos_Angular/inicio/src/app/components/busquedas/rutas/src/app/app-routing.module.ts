import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ComunicarComponent } from './components/comunicar/comunicar.component';
import { DosComponent } from './components/dos/dos.component';
import { HomeComponent } from './components/home/home.component';
import { UnoComponent } from './components/uno/uno.component';

const routes: Routes = [
  { path: 'uno', component: UnoComponent },
  { path: 'dos', component: DosComponent },
  { path: 'comunicar/:id', component: ComunicarComponent },
  { path: 'home', component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
