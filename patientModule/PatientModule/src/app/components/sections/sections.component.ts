import { Component, OnInit, Input } from '@angular/core';
import { QuestionsService } from 'src/app/services/questions.service';
import { DashboardComponent } from '../dashboard/dashboard.component';

@Component({
  selector: 'app-sections',
  templateUrl: './sections.component.html',
  styleUrls: ['./sections.component.css']
})
export class SectionsComponent implements OnInit {

  constructor(private questionService : QuestionsService) { }

   public questions: any
    // @Input() public name;
  ngOnInit(): void {
  }
  
  // public task1()
  // {
  //   this.questionService.section1(1).subscribe(
  //     (data:any) => {

  //       console.log('THe obtained list of questions is ',data)
  //       // window.location.href = "dashboard"
  //       this.questions = data;
  //       console.log(this.questions[0]);
  //     },
  //     (error:any) => {console.log('Error obtaining questions!',error)}
  //   )
  // }

}
