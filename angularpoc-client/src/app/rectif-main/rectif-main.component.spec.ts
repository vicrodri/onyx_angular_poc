import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RectifMainComponent } from './rectif-main.component';

describe('RectifMainComponent', () => {
  let component: RectifMainComponent;
  let fixture: ComponentFixture<RectifMainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RectifMainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RectifMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
