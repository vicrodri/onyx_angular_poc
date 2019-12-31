import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RectifListComponent } from './rectif-list.component';

describe('RectifListComponent', () => {
  let component: RectifListComponent;
  let fixture: ComponentFixture<RectifListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RectifListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RectifListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
