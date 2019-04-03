

```python
#imports
import pandas as pd
from datetime import datetime
import matplotlib.pyplot as plt
import numpy as np
```


```python
#convert to pandas dataframe for ease of access
f = pd.read_csv("C:\\Users\\aashi\\Desktop\Topos\DOB_Permit_Issuance.csv",header='infer') #replace the directory with your local one to point to the DOB dataset.
df = pd.DataFrame(f)
print(df.columns)
#df.head()
```

    C:\Users\aashi\Anaconda3\lib\site-packages\IPython\core\interactiveshell.py:2698: DtypeWarning: Columns (1,8,9,10,15,25,31,33,34,35,36,51,52) have mixed types. Specify dtype option on import or set low_memory=False.
      interactivity=interactivity, compiler=compiler, result=result)
    

    Index(['BOROUGH', 'Bin #', 'House #', 'Street Name', 'Job #', 'Job doc. #',
           'Job Type', 'Self_Cert', 'Block', 'Lot', 'Community Board', 'Zip Code',
           'Bldg Type', 'Residential', 'Special District 1', 'Special District 2',
           'Work Type', 'Permit Status', 'Filing Status', 'Permit Type',
           'Permit Sequence #', 'Permit Subtype', 'Oil Gas', 'Site Fill',
           'Filing Date', 'Issuance Date', 'Expiration Date', 'Job Start Date',
           'Permittee's First Name', 'Permittee's Last Name',
           'Permittee's Business Name', 'Permittee's Phone #',
           'Permittee's License Type', 'Permittee's License #',
           'Act as Superintendent', 'Permittee's Other Title', 'HIC License',
           'Site Safety Mgr's First Name', 'Site Safety Mgr's Last Name',
           'Site Safety Mgr Business Name', 'Superintendent First & Last Name',
           'Superintendent Business Name', 'Owner's Business Type', 'Non-Profit',
           'Owner's Business Name', 'Owner's First Name', 'Owner's Last Name',
           'Owner's House #', 'Owner's House Street Name', 'Owner’s House City',
           'Owner’s House State', 'Owner’s House Zip Code', 'Owner's Phone #',
           'DOBRunDate', 'PERMIT_SI_NO', 'LATITUDE', 'LONGITUDE',
           'COUNCIL_DISTRICT', 'CENSUS_TRACT', 'NTA_NAME'],
          dtype='object')
    


```python
#get dataframe with only residential values
df2 = df[['BOROUGH','Street Name','Zip Code','Residential','Bldg Type']]
df3 = df2[df2['Residential'] == "YES"]
df3.head(300)
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>BOROUGH</th>
      <th>Street Name</th>
      <th>Zip Code</th>
      <th>Residential</th>
      <th>Bldg Type</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>4</th>
      <td>QUEENS</td>
      <td>108 STREET</td>
      <td>11368.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>5</th>
      <td>BRONX</td>
      <td>W 261 STREET</td>
      <td>10471.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>6</th>
      <td>QUEENS</td>
      <td>81ST  ROAD</td>
      <td>11385.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>8</th>
      <td>QUEENS</td>
      <td>BEACH 96 STREET</td>
      <td>11693.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>9</th>
      <td>BROOKLYN</td>
      <td>SAINT MARKS PLACE</td>
      <td>11217.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>12</th>
      <td>MANHATTAN</td>
      <td>RECTOR PLACE</td>
      <td>10280.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>13</th>
      <td>BROOKLYN</td>
      <td>PROSPECT PL</td>
      <td>11233.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>15</th>
      <td>BROOKLYN</td>
      <td>BEDFORD AVENUE</td>
      <td>11249.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>16</th>
      <td>BROOKLYN</td>
      <td>7TH STREET</td>
      <td>11215.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>17</th>
      <td>BROOKLYN</td>
      <td>OCEAN PARKWAY</td>
      <td>11218.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>19</th>
      <td>BROOKLYN</td>
      <td>LIVINGSTON STREET</td>
      <td>11201.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>21</th>
      <td>MANHATTAN</td>
      <td>COLUMBUS AVENUE</td>
      <td>10024.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>22</th>
      <td>MANHATTAN</td>
      <td>GROVE STREET</td>
      <td>10014.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>24</th>
      <td>QUEENS</td>
      <td>101ST AVE</td>
      <td>11419.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>26</th>
      <td>QUEENS</td>
      <td>121 STREET</td>
      <td>11420.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>29</th>
      <td>QUEENS</td>
      <td>PALO ALTO AVENUE</td>
      <td>11423.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>32</th>
      <td>QUEENS</td>
      <td>217TH STREET</td>
      <td>11364.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>33</th>
      <td>QUEENS</td>
      <td>CORNELIA STREET</td>
      <td>11385.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>34</th>
      <td>MANHATTAN</td>
      <td>WEST 95 STREET</td>
      <td>10025.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>35</th>
      <td>BROOKLYN</td>
      <td>HALSEY ST</td>
      <td>11216.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>36</th>
      <td>QUEENS</td>
      <td>LABURNUM AVE</td>
      <td>11355.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>40</th>
      <td>MANHATTAN</td>
      <td>WEST 12 STREET</td>
      <td>10014.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>41</th>
      <td>BROOKLYN</td>
      <td>REMSEN STREET</td>
      <td>11201.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>43</th>
      <td>BROOKLYN</td>
      <td>79TH STREET</td>
      <td>11209.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>45</th>
      <td>MANHATTAN</td>
      <td>EAST 74TH STREET</td>
      <td>10021.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>47</th>
      <td>MANHATTAN</td>
      <td>WEST 19 STREET</td>
      <td>10011.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>48</th>
      <td>MANHATTAN</td>
      <td>EAST 48TH STREET</td>
      <td>10017.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>50</th>
      <td>BROOKLYN</td>
      <td>STRAUSS ST.</td>
      <td>11212.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>54</th>
      <td>QUEENS</td>
      <td>49 ST.</td>
      <td>11103.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>55</th>
      <td>BROOKLYN</td>
      <td>DEGRAW STREET</td>
      <td>11231.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>...</th>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
      <td>...</td>
    </tr>
    <tr>
      <th>485</th>
      <td>BRONX</td>
      <td>EAST TREMONT AVENUE</td>
      <td>10462.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>487</th>
      <td>BROOKLYN</td>
      <td>LORIMER ST</td>
      <td>11222.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>489</th>
      <td>MANHATTAN</td>
      <td>W 186 ST</td>
      <td>10033.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>491</th>
      <td>MANHATTAN</td>
      <td>WEST 176TH STREET</td>
      <td>10033.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>492</th>
      <td>BROOKLYN</td>
      <td>W 9 ST</td>
      <td>11223.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>493</th>
      <td>BROOKLYN</td>
      <td>55 ST</td>
      <td>11204.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>494</th>
      <td>BROOKLYN</td>
      <td>EAST    7 STREET</td>
      <td>11223.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>495</th>
      <td>BROOKLYN</td>
      <td>THOMAS BOYLAND ST</td>
      <td>11233.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>497</th>
      <td>BROOKLYN</td>
      <td>KNICKERBOCKER AV</td>
      <td>11221.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>498</th>
      <td>BROOKLYN</td>
      <td>FORT HAMILTON PARKWAY</td>
      <td>11218.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>501</th>
      <td>BROOKLYN</td>
      <td>NORTH ELLIOTT PLACE</td>
      <td>11205.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>502</th>
      <td>MANHATTAN</td>
      <td>WEST 109TH ST</td>
      <td>10025.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>503</th>
      <td>BRONX</td>
      <td>BOONE AVENUE</td>
      <td>10460.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>504</th>
      <td>MANHATTAN</td>
      <td>W 100 ST</td>
      <td>10025.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>506</th>
      <td>BROOKLYN</td>
      <td>TOMPKINS AVENUE</td>
      <td>11206.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>507</th>
      <td>MANHATTAN</td>
      <td>1ST AVENUE</td>
      <td>10016.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>509</th>
      <td>BROOKLYN</td>
      <td>MYRTLE AVENUE</td>
      <td>11206.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>510</th>
      <td>BROOKLYN</td>
      <td>MARLBOROUGH ROAD</td>
      <td>11226.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>511</th>
      <td>MANHATTAN</td>
      <td>WEST 27TH STREET</td>
      <td>10001.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>512</th>
      <td>BROOKLYN</td>
      <td>MARLBOROUGH ROAD</td>
      <td>11226.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>515</th>
      <td>MANHATTAN</td>
      <td>EAST 22 STREET</td>
      <td>10010.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>518</th>
      <td>BROOKLYN</td>
      <td>26TH STREET</td>
      <td>11232.0</td>
      <td>YES</td>
      <td>1.0</td>
    </tr>
    <tr>
      <th>522</th>
      <td>MANHATTAN</td>
      <td>LAFAYETTE STREET</td>
      <td>10003.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>524</th>
      <td>QUEENS</td>
      <td>FRESH POND RD</td>
      <td>11385.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>528</th>
      <td>BROOKLYN</td>
      <td>DUMONT AVE</td>
      <td>11212.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>530</th>
      <td>BROOKLYN</td>
      <td>DUMONT AVE</td>
      <td>11212.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>531</th>
      <td>BROOKLYN</td>
      <td>DUMONT AVE</td>
      <td>11212.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>532</th>
      <td>BROOKLYN</td>
      <td>VARICK AVE</td>
      <td>11237.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>533</th>
      <td>BROOKLYN</td>
      <td>DUMONT AVE</td>
      <td>11212.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
    <tr>
      <th>534</th>
      <td>MANHATTAN</td>
      <td>CENTRAL PARK WEST</td>
      <td>10025.0</td>
      <td>YES</td>
      <td>2.0</td>
    </tr>
  </tbody>
</table>
<p>300 rows × 5 columns</p>
</div>




```python
#Get list of zipcodes
temp = df3[df3['Zip Code'].notnull()]
zipcodes = temp['Zip Code'].values
zip2 = []

for x in zipcodes:
    zip2.append(int(x))

df4 = temp.drop(['Zip Code'],axis=1)
df4['Zip Code'] = zip2
df4.count()
```




    BOROUGH        1367940
    Street Name    1367940
    Residential    1367940
    Bldg Type      1364817
    Zip Code       1367940
    dtype: int64




```python
#read other files
f2 = pd.read_csv("C:\\Users\\aashi\\Desktop\Topos\Most_Expensive_Zipcodes.csv",header='infer') #this csv has been uploaded to the repo.
test = pd.DataFrame(f2)
mez_df = test.drop(['Unnamed: 4','Unnamed: 5','Unnamed: 6'],axis=1)
ranks_Arr = []
areas_Arr = []


for x in df4['Zip Code'].values:
    ranks = ""
    surrounding_areas = ""
    x1 = x.astype(str)
    for y in mez_df.values:
        y1 = str(y[3])
        temp = ""
        if x1 in y1:
            ranks = ranks +str(int(y[0]))+";"
            surrounding_areas = surrounding_areas +str(y[2])+";"
    ranks_Arr.append(ranks)
    areas_Arr.append(surrounding_areas)
```


```python
#Add surrounding areas and their ranks to the dataframe.
df4['Surrounding Areas'] = areas_Arr
df4['Surrounding Ranks'] = ranks_Arr
df4.head(10)
```

    BOROUGH              1367940
    Street Name          1367940
    Residential          1367940
    Bldg Type            1364817
    Zip Code             1367940
    Surrounding Areas    1367940
    Surrounding Ranks    1367940
    dtype: int64
    1367940
    1367940
    




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>BOROUGH</th>
      <th>Street Name</th>
      <th>Residential</th>
      <th>Bldg Type</th>
      <th>Zip Code</th>
      <th>Surrounding Areas</th>
      <th>Surrounding Ranks</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>4</th>
      <td>QUEENS</td>
      <td>108 STREET</td>
      <td>YES</td>
      <td>2.0</td>
      <td>11368</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th>5</th>
      <td>BRONX</td>
      <td>W 261 STREET</td>
      <td>YES</td>
      <td>1.0</td>
      <td>10471</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th>6</th>
      <td>QUEENS</td>
      <td>81ST  ROAD</td>
      <td>YES</td>
      <td>2.0</td>
      <td>11385</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th>8</th>
      <td>QUEENS</td>
      <td>BEACH 96 STREET</td>
      <td>YES</td>
      <td>2.0</td>
      <td>11693</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th>9</th>
      <td>BROOKLYN</td>
      <td>SAINT MARKS PLACE</td>
      <td>YES</td>
      <td>2.0</td>
      <td>11217</td>
      <td>DUMBO;Boerum Hill;Carroll Gardens;Gowanus;Fort...</td>
      <td>5;7;15;16;20;22;23;26;34;</td>
    </tr>
    <tr>
      <th>12</th>
      <td>MANHATTAN</td>
      <td>RECTOR PLACE</td>
      <td>YES</td>
      <td>2.0</td>
      <td>10280</td>
      <td>West Village;Battery Park City;Financial Distr...</td>
      <td>6;24;27;</td>
    </tr>
    <tr>
      <th>13</th>
      <td>BROOKLYN</td>
      <td>PROSPECT PL</td>
      <td>YES</td>
      <td>2.0</td>
      <td>11233</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th>15</th>
      <td>BROOKLYN</td>
      <td>BEDFORD AVENUE</td>
      <td>YES</td>
      <td>2.0</td>
      <td>11249</td>
      <td></td>
      <td></td>
    </tr>
    <tr>
      <th>16</th>
      <td>BROOKLYN</td>
      <td>7TH STREET</td>
      <td>YES</td>
      <td>1.0</td>
      <td>11215</td>
      <td>DUMBO;Boerum Hill;Carroll Gardens;Gowanus;Park...</td>
      <td>5;7;15;16;23;26;34;36;49;</td>
    </tr>
    <tr>
      <th>17</th>
      <td>BROOKLYN</td>
      <td>OCEAN PARKWAY</td>
      <td>YES</td>
      <td>2.0</td>
      <td>11218</td>
      <td>Fiske Terrace;Borough Park;</td>
      <td>37;47;</td>
    </tr>
  </tbody>
</table>
</div>




```python
#now check for subway stations. We basically look at the street name and compare if it has a station or not
f3 = pd.read_csv("C:\\Users\\aashi\\Desktop\Topos\Subway_Stations.csv",header='infer') #this data set has been uploaded to the repo. replace directory
subs_df = pd.DataFrame(f3)
subways = []
for x in df4.values:
    for y in subs_df.values:  
        if (x[1].lower() in y[0].lower()):
            subways.append("Yes")
            #print("Yes")
            break
        else:
            subways.append("No")
            break
```


```python
#final dataset
df4['Subway Nearby'] = subways
df4[df4['Subway Nearby'] == "No"]
df4['Surrounding Areas'].replace("", pd.np.nan, inplace=True)
df5 = df4.dropna()
final_df = df5[df5['Subway Nearby'] == "Yes"]
```




    BOROUGH              1865
    Street Name          1865
    Residential          1865
    Bldg Type            1865
    Zip Code             1865
    Surrounding Areas    1865
    Surrounding Ranks    1865
    Subway Nearby        1865
    dtype: int64




```python
#here we get a dataframe that has a subway nearby and has good surrounding areas. This isn't in any rank particularly. 
#The granularity of the data is at the street level.
final_df.head()
```




<div>
<style>
    .dataframe thead tr:only-child th {
        text-align: right;
    }

    .dataframe thead th {
        text-align: left;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>BOROUGH</th>
      <th>Street Name</th>
      <th>Residential</th>
      <th>Bldg Type</th>
      <th>Zip Code</th>
      <th>Surrounding Areas</th>
      <th>Surrounding Ranks</th>
      <th>Subway Nearby</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th>1340</th>
      <td>MANHATTAN</td>
      <td>THIRD AVENUE</td>
      <td>YES</td>
      <td>2.0</td>
      <td>10028</td>
      <td>Upper East Side;</td>
      <td>17;</td>
      <td>Yes</td>
    </tr>
    <tr>
      <th>3763</th>
      <td>MANHATTAN</td>
      <td>THIRD AVENUE</td>
      <td>YES</td>
      <td>2.0</td>
      <td>10016</td>
      <td>Garment District;Flatiron District;Gramercy Pa...</td>
      <td>3;8;21;38;</td>
      <td>Yes</td>
    </tr>
    <tr>
      <th>3766</th>
      <td>MANHATTAN</td>
      <td>THIRD AVENUE</td>
      <td>YES</td>
      <td>2.0</td>
      <td>10016</td>
      <td>Garment District;Flatiron District;Gramercy Pa...</td>
      <td>3;8;21;38;</td>
      <td>Yes</td>
    </tr>
    <tr>
      <th>4229</th>
      <td>BROOKLYN</td>
      <td>THIRD AVENUE</td>
      <td>YES</td>
      <td>2.0</td>
      <td>11215</td>
      <td>DUMBO;Boerum Hill;Carroll Gardens;Gowanus;Park...</td>
      <td>5;7;15;16;23;26;34;36;49;</td>
      <td>Yes</td>
    </tr>
    <tr>
      <th>4501</th>
      <td>MANHATTAN</td>
      <td>THIRD AVENUE</td>
      <td>YES</td>
      <td>2.0</td>
      <td>10016</td>
      <td>Garment District;Flatiron District;Gramercy Pa...</td>
      <td>3;8;21;38;</td>
      <td>Yes</td>
    </tr>
  </tbody>
</table>
</div>


