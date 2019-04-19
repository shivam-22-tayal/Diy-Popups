export class Advertisement{
  id: number;
  categoryadd: string;
  product: string;
  dop: string;
  description: string;
  constructor(categoryadd: string, product: string, dop: string, description: string) {
  this.categoryadd = categoryadd;
  this.product = product;
  this.dop = dop;
  this.description = description;

  }
}
