require 'calabash-android/calabash_steps'

Then /^I should be in the "([^"]+)" page$/ do |page_title|
  step('I see "Taco"')
  step('I see "GO"')
  step('I see "results ..."')   
end 

