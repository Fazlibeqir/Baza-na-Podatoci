export class GameReviewsView{
  id_review:number;
  rating:number;
  comment:string;
  username:string;
  id_game:number;
  game_title:string;
  game_genre:string;
  constructor(
    id_review:number,
    rating:number,
    comment:string,
    username:string,
    id_game:number,
    game_title:string,
    game_genre:string,
  ){
    this.id_review=id_review;
    this.rating=rating;
    this.comment=comment;
    this.username=username;
    this.id_game=id_game;
    this.game_title=game_title;
    this.game_genre=game_genre;
  }
}
