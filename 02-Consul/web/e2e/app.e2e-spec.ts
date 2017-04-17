import { QuotePage } from './app.po';

describe('quote App', () => {
  let page: QuotePage;

  beforeEach(() => {
    page = new QuotePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('qt works!');
  });
});
