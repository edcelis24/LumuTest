#Author: edcelis

Feature:  Validate word, character and keyword counts

  As a WordCounter user
  I need to validate a series of texts
  To validate its structure

  Background:
    Given that the user opens the WordCounter page

  @testLocal
  Scenario: Word count verification
    When he enters text in the editor
    Then he sees the number of words contained in the text