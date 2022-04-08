import { Component, OnInit } from '@angular/core';
import { MoodService } from 'src/app/services/mood.service';

@Component({
  selector: 'app-mood',
  templateUrl: './mood.component.html',
  styleUrls: ['./mood.component.css']
})
export class MoodComponent implements OnInit {

  constructor(private moodService : MoodService) { }

  mood = 0;

  ngOnInit(): void {
  }

  public submit()
  {
    console.log(this.mood);
  }

  public one()
  {
    this.moodService.storeMood(1).subscribe(
      (data:any) => {

        console.log('Mood Stored!',data),alert("Mood stored!")
        window.location.href = "dashboard"

      },
      (error:any) => {console.log('Error storing mood!',error)}
    )
  }


  public two()
  {
    this.moodService.storeMood(2).subscribe(
      (data:any) => {

        console.log('Mood Stored!',data),alert("Mood stored!")
        window.location.href = "dashboard"

      },
      (error:any) => {console.log('Error storing mood!',error)}
    )
  }


  public three()
  {
    this.moodService.storeMood(3).subscribe(
      (data:any) => {

        console.log('Mood Stored!',data),alert("Mood stored!")
        window.location.href = "dashboard"

      },
      (error:any) => {console.log('Error storing mood!',error)}
    )
  }


  public four()
  {
    this.moodService.storeMood(4).subscribe(
      (data:any) => {

        console.log('Mood Stored!',data),alert("Mood stored!")
        window.location.href = "dashboard"

      },
      (error:any) => {console.log('Error storing mood!',error)}
    )
  }


  public five()
  {
    this.moodService.storeMood(5).subscribe(
      (data:any) => {

        console.log('Mood Stored!',data),alert("Mood stored!")
        window.location.href = "dashboard"

      },
      (error:any) => {console.log('Error storing mood!',error)}
    )
  }

}
