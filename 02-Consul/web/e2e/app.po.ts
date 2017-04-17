import { browser, element, by } from 'protractor';

export class QuotePage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('qt-root h1')).getText();
  }
}
