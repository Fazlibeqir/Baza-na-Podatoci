export class Review{
  rating: number;
    comment: string;
    idUser: number;
    idGame: number;
    constructor(
        rating: number,
        comment: string,
        idUser: number,
        idGame: number,
    ) {
        this.rating = rating;
        this.comment = comment;
        this.idUser = idUser;
        this.idGame = idGame;
    }
}
