/**
 * Created by Navya on 2/7/2017.
 */

function sourceWeatherDetails() {

    var source = document.getElementById("origin-input").value;

    $.getJSON('https://api.wunderground.com/api/36b799dc821d5836/conditions/q/'+source+'.json', function(data) {
        //data is the JSON string
        //var data = JSON.parse(json);

        source_temp = data.current_observation.temp_f;
        source_icon = data.current_observation.icon_url;
        source_weather = data.current_observation.weather;
        document.getElementById('sourceWeatherDetails').value = "The temperature of " + source+ " is " +source_temp+ " and weather details are "+source_weather+ "";
        document.getElementById('sourceWeatherDetails').type = "text";

        //
    });
   }
   function destWeatherDetails() {
       var destination = document.getElementById("destination-input").value;

    $.getJSON('https://api.wunderground.com/api/36b799dc821d5836/conditions/q/'+destination+'.json', function(data) {
        //data is the JSON string

        //var data = JSON.parse(json);

        dest_temp = data.current_observation.temp_f;
        dest_icon = data.current_observation.icon_url;
        dest_weather = data.current_observation.weather;
        document.getElementById('destWeatherDetails').value = "The temperature of " +destination + " is " +dest_temp+ " and weather details are "+dest_weather+ "";
        document.getElementById('destWeatherDetails').type = "text";

        //
    });

}