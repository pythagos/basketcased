/*! Bing Search Helper v1.0.0 - requires jQuery v1.9.0 */

$(function () {

    $('textarea[name=content]', '#my_form').change(function () { updateUI(); });
    $('#the_greeting').focus();
    
 // Event Handlers
    // Attaches a click handler to the SEARCH button.
    $('#bt_search').click(function (e) {
        e.preventDefault();
        globalIndex = 0;

        if ($('#query').val()) {
            // search();
        }
    });
    
    function updateUI() {
        var query = $('#the_greeting').val();
    }
});
