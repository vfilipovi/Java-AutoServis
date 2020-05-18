import { Component, OnInit } from '@angular/core';
import { StudentService } from '../klijent.service';
import { Student } from '../klijent.model';
import { ActivatedRoute } from '@angular/router';
import { switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-student-edit',
  templateUrl: './student-edit.component.html'
})
export class StudentEditComponent implements OnInit {

  student: Student;

  constructor(
    private route: ActivatedRoute,
    private studentService: StudentService,
  ) { }

  ngOnInit(): void {
    this.route.paramMap.pipe(
      switchMap(params => {
        const jmbag = params.get('jmbag');
        return this.studentService.getStudent(jmbag);
      }
      )
    ).subscribe((student: Student) => {
      this.student = student;
    });
  }

}
