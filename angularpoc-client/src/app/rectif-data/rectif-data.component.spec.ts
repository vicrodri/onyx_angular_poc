import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RectifDataComponent } from './rectif-data.component';

describe('RectifDataComponent', () => {
  let component: RectifDataComponent;
  let fixture: ComponentFixture<RectifDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RectifDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RectifDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
