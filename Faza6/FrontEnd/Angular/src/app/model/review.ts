export class Review{
  id_review: number;
  rating: number;
    comment: string;
    idUser: number;
    idGame: number;
    constructor(
        id_review: number,
        rating: number,
        comment: string,
        idUser: number,
        idGame: number,
    ) {
      this.id_review = id_review;
        this.rating = rating;
        this.comment = comment;
        this.idUser = idUser;
        this.idGame = idGame;
    }
}
