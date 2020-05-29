export class Charity
{
    constructor(public title:string, public description:string,
                public volunteersNeeded:number, public volunteers: number,
                public moneyNeeded: number, public moneyDonated: number,
                public creatorsUsername: string, public id:number){}
}