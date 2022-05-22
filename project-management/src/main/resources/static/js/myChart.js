const chartDataStr = decodeHTML(chartData);
const chartJsonArray = JSON.parse(chartDataStr);

const arrayLength = chartJsonArray.length;
const numericData = [];
const labelData = [];

for(let index = 0; index < arrayLength; index++){
	numericData[index] = chartJsonArray[index].value;
	labelData[index] = chartJsonArray[index].label;
}

const ctx = document.getElementById('myPieChart');
const data = {
	// The data for our data set
  labels: labelData,
  datasets: [{
    label: 'My First Dataset',
    data: numericData,
    backgroundColor: [
      'rgb(255, 99, 132)',
      'rgb(54, 162, 235)',
      'rgb(255, 205, 86)'
    ],
    hoverOffset: 4
  }]
};

const options =  {
        plugins: {
            title: {
                display: true,
                text: 'Project Statuses'
            }
        }
    }

const config = {
  type: 'pie',
  data: data,
  options: options
};



const myChart = new Chart(ctx, config);

// [{"value": 1, "label": "COMPLETED"}, {"value": 2, "label": "INPROGRESS"}, {"value": 2, "label": "NOTCOMPLETED"}]
function decodeHTML(html){
	const txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}