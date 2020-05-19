import { Component, OnInit, Input } from '@angular/core';
import { Kvar } from '../kvar.model';
import { ActivatedRoute } from '@angular/router';
import { KvarService } from '../kvar.service';
//import { CourseService } from '../../course/course.service';
//import { Course } from '../../course/course.model'; //VJV JE TO VANJSKA VEZA U BAZI
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-kvar-detail',
  templateUrl: './kvar-detail.component.html'
})
export class KvarDetailComponent implements OnInit {

  @Input() kvar: Kvar;
  //courses: Course[];

  id: number;

  constructor(
    private route: ActivatedRoute,
    private kvarService: KvarService,
    //private courseService: CourseService
  ) { }


  ngOnInit() {
    this.kvar = new Kvar();

    this.id = this.route.snapshot.params['id'];

    this.kvarService.getKvar(this.id)
      .subscribe(data => {
        console.log(data)
        this.kvar = data;
      }, error => console.log(error));
  }


  /*ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        const id = params.get('id');
        return this.kvarService.getKvar(id);
      }
      )
    ).subscribe((kvar: Kvar) => {
      this.kvar = kvar;
    });
  }
*/
}
