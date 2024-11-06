#Author: edcelis

Feature:  Validate word, character and keyword counts

  As a WordCounter user
  I need to validate a series of texts
  To validate its structure

  Background:
    Given that the user opens the WordCounter page

  Scenario: Repeated words count verification
    When he enters 150 words text in the editor
    Then he sees the number of repeated words contained in the text

  Scenario: Words count verification
    When he enters 200 words text in the editor
    Then he sees the number of words contained in the text

  Scenario: Characters count verification
    When he enters 50 words text in the editor
    Then he sees the number of characters contained in the text