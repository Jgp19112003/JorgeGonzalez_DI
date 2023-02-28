import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComunicarComponent } from './comunicar.component';

describe('ComunicarComponent', () => {
  let component: ComunicarComponent;
  let fixture: ComponentFixture<ComunicarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComunicarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComunicarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
